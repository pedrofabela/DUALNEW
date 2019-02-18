FROM reg.edu-edomex.gob.mx/java/tomcat85-jre8
RUN ["rm", "-rf", "/usr/local/tomcat/webapps/ROOT"]
ADD dist/ROOT.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]
