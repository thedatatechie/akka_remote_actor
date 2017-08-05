FROM centos:latest

RUN mkdir /usr/java
WORKDIR /usr/java
RUN yum install -y wget
RUN wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u141-b15/336fa29ff2bb4ef291e347e091f7f4a7/jdk-8u141-linux-x64.tar.gz"
RUN tar xvf jdk-8u141-linux-x64.tar.gz
#COPY /opt/jdk1.8.0_141 /usr/java/
#RUN export JAVA_HOME=/usr/java/jdk1.8.0_141
#RUN export JRE_HOME=/usr/java/jdk1.8.0_141/jre
#RUN PATH=$PATH:$HOME/bin:$JAVA_HOME/bin
#RUN export PATH
#RUN alternatives --install /usr/bin/java java /opt/jdk1.8.0_141/bin/java 2
#RUN alternatives --config java
RUN sh -c "echo export JAVA_HOME=/usr/java/jdk1.8.0_141/jre >> /etc/environment"
#java -version
WORKDIR /usr/lib
RUN wget http://www.scala-lang.org/files/archive/scala-2.11.8.tgz
RUN tar xvf scala-2.11.8.tgz
#COPY scala-2.11.8 /usr/lib
RUN ln -s /usr/lib/scala-2.11.8 /usr/lib/scala
#scala -version
#VOLUME ["D:\Personal\Akka_Cluster\files_toDocker_container"]
#EXPOSE 2552 2553 2554
RUN yum install -y vim
ENV JAVA_HOME=/usr/java/jdk1.8.0_141
ENV JRE_HOME=/usr/java/jdk1.8.0_141/jre
ENV PATH=$PATH:$HOME/bin:$JAVA_HOME/bin
ENV PATH=$PATH:/usr/lib/scala/bin