FROM tomcat

RUN mkdir /home/hsw
WORKDIR /home/hsw

# Install maven 
RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz && \
    tar -xzvf apache-maven-3.9.6-bin.tar.gz && \
    mv apache-maven-3.9.6 maven && \
    rm apache-maven-3.9.6-bin.tar.gz && \
    ln -s /home/hsw/maven/bin/mvn /usr/bin/mvn 

RUN mkdir /home/hsw/FirstServlet
COPY FirstServlet /home/hsw/FirstServlet
WORKDIR /home/hsw/FirstServlet
RUN mvn clean install 
RUN cp /home/hsw/FirstServlet/target/FirstServlet-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps

EXPOSE 8080
