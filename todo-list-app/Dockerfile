FROM clojure:lein
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# Utilizar HOST = host.docker.internal em MacOs, Windows
# Utilizar HOST = <sudo ip addr show docker0> em Linux
ENV DATABASE_HOST=host.docker.internal
ENV DATABASE_SCHEMA=todolist
ENV DATABASE_PORT=3307
ENV DATABASE_USER=root
ENV DATABASE_PASSWORD=s3cr3t

# Load deps into build, should auto fetch new deps
COPY ./todo/project.clj /usr/src/app/
RUN lein deps
COPY ./todo /usr/src/app/

CMD lein ring server-headless