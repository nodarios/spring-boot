### Description
* The service acts as spring boot howto app

---

### Startup
* Run docker-compose
* Run application

---

### Jolokia
* used to access jmx mbeans via http  
[exec mbean method](http://localhost:8080/actuator/jolokia/exec/org.springframework.boot:type=Endpoint,name=Loggers/loggers)  
[exec mbean method with argument](http://localhost:8080/actuator/jolokia/exec/org.springframework.boot:type=Endpoint,name=Loggers/configureLogLevel/pak/INFO)  
[read mbean attributes](http://localhost:8080/actuator/jolokia/read/pak.jmx:type=MyFlag,name=myFlag)  
[write mbean attribute](http://localhost:8080/actuator/jolokia/write/pak.jmx:type=MyFlag,name=myFlag/Status/true)  

---

### Micrometer
micrometer is a facade, here sending metrics to datadog  
to check result, use below link or netcat command:  
* [view specific metric](http://localhost:8080/actuator/metrics/mm.my-metric.total)  
* `ncat -ul 8125`  
