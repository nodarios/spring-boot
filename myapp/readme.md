### Description
* The service acts as spring boot howto app

---

```
script
```

---

### Jolokia
[exec mbean method](http://localhost:8080/actuator/jolokia/exec/org.springframework.boot:type=Endpoint,name=Loggers/loggers)  
[exec mbean method with argument](http://localhost:8080/actuator/jolokia/exec/org.springframework.boot:type=Endpoint,name=Loggers/configureLogLevel/pak/INFO)  
[read mbean attributes](http://localhost:8080/actuator/jolokia/read/pak.jmx:type=MyFlag,name=myFlag)  
[write mbean attribute](http://localhost:8080/actuator/jolokia/write/pak.jmx:type=MyFlag,name=myFlag/Status/true)  
