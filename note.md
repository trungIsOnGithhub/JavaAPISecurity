#### High level modules should not depend on low level modules, both should depend upon abstractions.

> High level modules –  contain your business logic, important meat of application
> should not depend on lower level components(implementation, utilities)

> Dependency injection concept of ASSEMBLER 4 – in Java is commonly as a FACTORY -- that instantiates objects required by an application and "injects" them into their dependent objects.

##### Spring uses concept of BeanFactory as its assembler
> IoC container manages a bean's scope, lifecycle
events, and any AOP features for which it has been configured and coded.
> Spring bean in the IoC typically is POJO complete entities themselves and IoC container resolve, inject dependencies they need.
> interesting thing to is, Spring injects the dependencies, even if the field is private. Spring uses Java Reflections to do so.