# PrePro
#### Student project at the DHBW Karlsruhe

The Language is designed to simply calculations with time series. To do so, each variable (except of constants) is a time-series. For example a variable with the type vec3 is a time-series of Vectors with the length 3.
A PrePro-programm is written in a specific Domain Specific Language in textual form and is run by an Interpreter. The Interpreter takes and returns an PreProDataSet, which stores a set of variables (time-series).

## Contents of this repository
| Folder                    | Contents                                                                               |
| ------------------------- | -------------------------------------------------------------------------------------- |
| PrePro                    | The source code of the interpreter.                                                    |
| PrePro-Netbeans-Plugin    | A plugin for the Netbeans IDE supporting syntax highliting and syntax error detection. |
| Elaboration               | The document written for the university. It is written in german.                      |

## A simple PrePro-Programm
```
import vec3 p1, p2;

vec3 result = p1 + p2;

export result;
```


It uses the variables p1 and p2 from the given PreProDataSet and calculates a resulting Vector3. Remind: All the variables are time-series, there is no need for a loop. The Interpreter will return a PreProDataSet containing the result.

## Functions:
```
function main() {
	import vec3 p1, vec3 p2, vec3 p3;

	vec3 x = calculateDifference(p1, p2);
	vec3 s = calculateDifference(p1, p3);
	vec3 y = s X x;
	vec3 z = y X x;

	export x, y, z;
}

function calculateDifference(vec3 p1, vec3 p2) returns vec3 {
	return p2 - p1;
}
```
The operation “X” is a cross product. Note, that PrePro currently doesn't support overloading of functions.

So, when the PrePro-programm is defined, you can run it. You must provide a PreProDataSet. The following code creates a PreProDataSet and calls a specific PrePro-progam.

## Constants

Constants can be defined and set into the SymbolTable:

```java
PreProProgram program = new PreProProgram("foo.prepro");
SymbolTable symbolTable = new SymbolTable();
symbolTable.setValue("pi", new Constant(Math.PI);
PreProDataSet result = program.execute(dataSet, symbolTable);
double pi = result.getVariable()("pi").getDouble(0,0);
```

Limitations: Only double constants available?

## Run the PrePro-program
```java
INDArray p1 = Nd4j.create(new double[]{42, 0, 0, 1, 0, 0, 5, 0, 0, 6, 0, 0, 1, 2, 3}, new int[]{4, 3});
INDArray p2 = Nd4j.create(new double[]{43, 0, 0, 44662, 0, 0, 6, 0, 0, 7, 0, 0}, new int[]{4, 3});
INDArray p3 = Nd4j.create(new double[]{42, 0, 1, 1, 0, 1, 5, 0, 1, 6, 0, 1}, new int[]{4, 3});

PreProDataSet preProDataSet = new DefaultPreProDataSet(
        Arrays.asList(p1, p2, p3),
        Arrays.asList("p1", "p2", "p3")
);

PreProProgram program = new PreProProgram("src/test/tests/arithmetic/testCrossProduct.prepro");
PreProDataSet result = program.execute(preProDataSet);

System.out.println("Calculated x:\n" + result.getVariable("x"));
System.out.println("Calculated y:\n" + result.getVariable("y"));
System.out.println("Calculated z:\n" + result.getVariable("z"));
```
