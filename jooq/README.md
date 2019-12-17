# JOOQ Code Generation

Even though JOOQ Code Generation is optional it is quite
useful to be able to rely on compile time errors.

The following jar files are need hence have to be downloaded:

https://repo1.maven.org/maven2/org/jooq/jooq/3.12.3/jooq-3.12.3.jar
https://repo1.maven.org/maven2/org/jooq/jooq-meta/3.12.3/jooq-meta-3.12.3.jar
https://repo1.maven.org/maven2/org/jooq/jooq-codegen/3.12.3/jooq-codegen-3.12.3.jar
https://repo1.maven.org/maven2/org/reactivestreams/reactive-streams/1.0.2/reactive-streams-1.0.2.jar
https://repo1.maven.org/maven2/org/postgresql/postgresql/42.2.9/postgresql-42.2.9.jar


__Command to run jooq code Generation__

```bash
java -cp jooq-3.12.3.jar;jooq-meta-3.12.3.jar;jooq-codegen-3.12.3.jar;reactive-streams-1.0.2.jar;postgresql-42.2.9.jar org.jooq.codegen.GenerationTool <XML-file>
```

As of now there is an issue with Java 9 and higher as JAXB support was changed. That is why
running this JOOQ code gen task with 11 will result in the following error:

```
jooq/generate 
Dec 17, 2019 4:28:52 PM org.jooq.tools.JooqLogger info
INFO: Initialising properties  : /Users/kgalli/dev/bookshop/jooq/jooq-config.xml
Exception in thread "main" java.lang.NoClassDefFoundError: javax.xml.bind.annotation.XmlSchema
	at org.jooq.util.jaxb.tools.MiniJAXB.getNamespace(MiniJAXB.java:389)
	at org.jooq.util.jaxb.tools.MiniJAXB.addDefaultNamespace(MiniJAXB.java:182)
	at org.jooq.util.jaxb.tools.MiniJAXB.unmarshal0(MiniJAXB.java:169)
	at org.jooq.util.jaxb.tools.MiniJAXB.unmarshal(MiniJAXB.java:155)
	at org.jooq.codegen.GenerationTool.load(GenerationTool.java:972)
	at org.jooq.codegen.GenerationTool.main(GenerationTool.java:188)
Caused by: java.lang.ClassNotFoundException: javax.xml.bind.annotation.XmlSchema
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:766)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:1077)
	... 6 more
```

Solution is for now to use `sdkman` to switch to Java 8 run the code generation
and switch back to Java 11. Silly workaround but still the fastest way to get files generated.
In the future the JOOQ code gen project plans to provide proper script for that.
