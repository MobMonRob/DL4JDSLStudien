package main;

import nodes.MainNode;
import nodes.function.Arguments;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import parser.PreProLexer;
import parser.PreProParser;
import variables.Variable;
import variables.Vector3;

import java.io.IOException;

public class Main {

    //    public static void main(String[] args) throws IOException {
//        PreProLexer lexer = new PreProLexer(CharStreams.fromFileName("src/test/java/test.prepro"));
//        MainNode main = new PreProParser(new CommonTokenStream(lexer)).prepro().result;
//
//        Nd4j.ENFORCE_NUMERICAL_STABILITY = true;
//
//        Vector3 p1 = new Vector3(Nd4j.create(new double[]{42, 0, 0,  1, 0, 0,   5, 0, 0,   6, 0, 0},   new int[]{4,3}));
//        Vector3 p2 = new Vector3(Nd4j.create(new double[]{43, 0, 0,  44662, 0, 0,   6, 0, 0,   7, 0, 0},   new int[]{4,3}));
//        Vector3 p3 = new Vector3(Nd4j.create(new double[]{42, 0, 1,  1, 0, 1,   5, 0, 1,   6, 0, 1},   new int[]{4,3}));
//
//        Arguments arguments = new Arguments(new Variable[]{p1, p2, p3});
//        main.execute(arguments);
//    }

    public static void main(String[] args) {
        Vector3 p1 = new Vector3(Nd4j.create(new double[]{42, 0, 0, 1, 0, 0, 5, 0, 0, 6, 0, 0,1,2,3}, new int[]{4, 3}));
        Vector3 p2 = new Vector3(Nd4j.create(new double[]{43, 0, 0, 44662, 0, 0, 6, 0, 0, 7, 0, 0}, new int[]{4, 3}));
        Vector3 p3 = new Vector3(Nd4j.create(new double[]{42, 0, 1, 1, 0, 1, 5, 0, 1, 6, 0, 1}, new int[]{4, 3}));


        INDArray features = Nd4j.create(new int[]{3, p1.getNdArray().length()});
        features.putRow(0, p1.getNdArray());
        features.putRow(1, p2.getNdArray());
        features.putRow(2, p3.getNdArray());
        DataSet dataSet = new DataSet(features, null);
        String[] variableNames = new String[]{"p1", "p2", "p3"};
        int[][] variableShapes =
                new int[][]{p1.getNdArray().shape(), p2.getNdArray().shape(), p3.getNdArray().shape()};
        PreProDataSet preProDataSet = new PreProDataSet(dataSet, variableNames, variableShapes);

        PreProProgram program = new PreProProgram("src/test/java/test2.prepro");
        PreProDataSet result = program.execute(preProDataSet);
    }
}