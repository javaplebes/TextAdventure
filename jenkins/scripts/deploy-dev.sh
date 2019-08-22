#!/usr/bin/env sh

#
# Will change this so it copies the latest build created by Jenkins
# so the DEV server won't have to rebuild an already built project.
#

ORG_PATH="~/JavaPlebes"
PROJ_DIR="/TextAdventure"
GIT_URL="git@github.com:javaplebes/TextAdventure.git"

if [ ! -d "$ORG_PATH" ]; then
  echo "Organisation path does not exist. Creating..."
  mkdir ORG_PATH
fi

cd $ORG_PATH

if [ -! -d "$PROJ_DIR" ]; then
  echo "Project directory does not exist. Cloning latest from GitHub..."
  git clone $GIT_URL $PROJ_DIR
fi

cd $PROJ_DIR

echo "Pulling the latest master branch..."
git pull origin master

echo "Deploy not yet implemented!"