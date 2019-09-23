FROM jboss/wildfly
ADD target/javaee-jcache-redisson.war ${JBOSS_HOME}/standalone/deployments/javaee-jcache-redisson.war
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]