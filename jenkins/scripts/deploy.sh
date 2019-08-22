#!/usr/bin/env sh

# Todo: Write a simple deploy script
echo "Deploy not implemented yet!"

echo "Running the deployment script on DEV environment..."
ssh jenkins-ci@shard-server-lon01 'bash -s' < deploy-dev.sh