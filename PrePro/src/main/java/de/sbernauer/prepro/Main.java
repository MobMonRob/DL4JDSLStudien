package de.sbernauer.prepro;

import de.sbernauer.prepro.dataset.DefaultPreProDataSet;
import de.sbernauer.prepro.dataset.PreProDataSet;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.Arrays;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {
        INDArray p1 = Nd4j.create(new double[]{42, 0, 0, 1, 0, 0, 5, 0, 0, 6, 0, 0, 1, 2, 3}, new int[]{4, 3});
        INDArray p2 = Nd4j.create(new double[]{43, 0, 0, 44662, 0, 0, 6, 0, 0, 7, 0, 0}, new int[]{4, 3});
        INDArray p3 = Nd4j.create(new double[]{42, 0, 1, 1, 0, 1, 5, 0, 1, 6, 0, 1}, new int[]{4, 3});

        INDArray testMat3_1 = Nd4j.create(IntStream.range(1, 36 + 1).mapToDouble(i -> i).toArray(), new int[]{4, 3, 3});
        INDArray testMat3_2 = Nd4j.create(IntStream.range(1, 36 * 2 + 1).filter(i -> i % 2 == 0).mapToDouble(i -> i).toArray(), new int[]{4, 3, 3});

        INDArray testMat4_1 = Nd4j.create(IntStream.range(1, 64 + 1).mapToDouble(i -> i).toArray(), new int[]{4, 4, 4});
        INDArray testMat4_2 = Nd4j.create(IntStream.range(1, 64 * 2 + 1).filter(i -> i % 2 == 0).mapToDouble(i -> i).toArray(), new int[]{4, 4, 4});

        INDArray numbers = Nd4j.create(new double[]{1, 2, 3, 4}, new int[]{4, 1});

        PreProDataSet preProDataSet = new DefaultPreProDataSet(
                Arrays.asList(p1, p2, p3, testMat3_1, testMat3_2, testMat4_1, testMat4_2, numbers),
                Arrays.asList("p1", "p2", "p3", "testMat3_1", "testMat3_2", "testMat4_1", "testMat4_2", "numbers")
        );

        PreProProgram program = new PreProProgram("src/test/tests/arithmetic/testCrossProduct.prepro");
        PreProDataSet result = program.execute(preProDataSet);

        System.out.println("Calculated x:\n" + result.getVariable("x"));
        System.out.println("Calculated y:\n" + result.getVariable("y"));
        System.out.println("Calculated z:\n" + result.getVariable("z"));
    }
}