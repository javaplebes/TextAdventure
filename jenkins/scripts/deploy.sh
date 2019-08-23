#!/usr/bin/env sh

deploy_to_env() {
  if [ -z "$1" ] || [ "$1" = "DEV" ]; then
    echo "Deploying to DEV environment."
    ssh "${PROJ_USER}"@"${DEV_SERVER}" "bash -s" < deploy-dev.sh
  elif [ "$1" = "PREPROD" ]; then
    echo "Deploying to PREPROD environment."
    ssh "${PROJ_USER}"@"${PREPROD_SERVER}" "bash -s" < deploy-preprod.sh
  elif [ "$1" = "PROD" ]; then
    echo "Deploying to PROD environment."
    ssh "${PROJ_USER}"@"${PROD_SERVER}" "bash -s" < deploy-prod.sh
  else
    echo "Unknown environment."
    return 1
  fi
}

check_environment() {
  if [ -z "${PROJ_USER}" ] \
  || [ -z "${DEV_SERVER}" ] \
  || [ -z "${PREPROD_SERVER}" ] \
  || [ -z "${PROD_SERVER}" ]; then
    return 1
  fi
}

if ! check_environment ; then
  echo "Environment is not correctly set up. Exiting..."
  exit 1
else
  if ! deploy_to_env "$@" ; then
    echo "Something went wrong during deployment. Exiting..."
  else
    echo "Successfully deployed to server. [$1]"
  fi
fi