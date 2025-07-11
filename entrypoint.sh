#!/usr/bin/env sh

readonly WORKDIR=/app # WORKDIR from Containerfile

configure_runtime_config() {
  if [ ! -e "${WORKDIR}/config" ]; then
    mkdir "${WORKDIR}/config"
  fi

  cp /mnt/configurations/application.yaml "${WORKDIR}/config"
}

configure_runtime_config
java -jar app.jar
