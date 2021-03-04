# 基于java镜像创建新镜像
FROM java:8
# 作者
MAINTAINER silence
# 默认挂载
VOLUME [ "/temp" ]
# 将jar包添加到容器中并更名为*.jar
ADD silence-0.0.1-SNAPSHOT.jar silence-0.0.1-SNAPSHOT.jar
# 运行jar包
ENTRYPOINT ["nohup","java","-jar","silence-0.0.1-SNAPSHOT.jar","--server.port=8888","--spring.profiles.active-dev","subversion&"]