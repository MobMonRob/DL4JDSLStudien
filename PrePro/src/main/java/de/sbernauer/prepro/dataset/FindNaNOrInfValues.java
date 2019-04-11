package de.sbernauer.prepro.dataset;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.impl.accum.MatchCondition;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.conditions.Conditions;

public class FindNaNOrInfValues {
    public static void checkForNaNOrInf(PreProDataSet preProDataSet) {
        for (String variableName : preProDataSet.getVariableNames()) {
            checkForNaNOrInf(preProDataSet.getVariable(variableName), variableName);
        }
    }

    public static void checkForNaNOrInf(INDArray array, String arrayName) {
        int countNaN = Nd4j.getExecutioner()
                .exec(new MatchCondition(array, Conditions.isNan()), Integer.MAX_VALUE).getInt(0);
        int countInfinite = Nd4j.getExecutioner()
                .exec(new MatchCondition(array, Conditions.isInfinite()), Integer.MAX_VALUE).getInt(0);

        if (countNaN > 0 || countInfinite > 0) {

            System.err.println("WARNING: Given array " + arrayName + " has " + countNaN + " NaN and " + countInfinite + " infinite values!");
            System.err.println(arrayName + ":\n" + array);
        }
    }
}
