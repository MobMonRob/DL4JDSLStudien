# DL4JDSLStudien
Studienarbeit - DSL forDL4J

Basic usage:
```java
INDArray p1 = Nd4j.create(new double[]{42, 0, 0, 1, 0, 0, 5, 0, 0, 6, 0, 0, 1, 2, 3}, new int[]{4, 3});
INDArray p2 = Nd4j.create(new double[]{43, 0, 0, 44662, 0, 0, 6, 0, 0, 7, 0, 0}, new int[]{4, 3});
INDArray p3 = Nd4j.create(new double[]{42, 0, 1, 1, 0, 1, 5, 0, 1, 6, 0, 1}, new int[]{4, 3});

PreProDataSet preProDataSet = new PreProDataSet(
        Arrays.asList(p1, p2, p3),
        Arrays.asList("p1", "p2", "p3")
);

PreProProgram program = new PreProProgram("src/test/java/test2.prepro");
PreProDataSet result = program.execute(preProDataSet);
```
