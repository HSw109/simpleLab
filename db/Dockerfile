FROM gvenzl/oracle-xe

WORKDIR /opt/oracle
COPY ./oracle_sample.sql .
COPY ./entrypoint.sh /docker-entrypoint-initdb.d/entrypoint.sh

EXPOSE 1521
