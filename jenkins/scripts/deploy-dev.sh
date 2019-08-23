#!/usr/bin/env sh

get_xpath_value() {
    xml=$1
    path=$2
    if [ -f "${xml}" ]; then
        value=$( xpath "${xml} ${path}" 2>/dev/null | perl -pe 's/^.+?\>//; s/\<.+?$//;' )
        echo "${value}"
    else
        echo "Invalid xml file: ${xml}!"
        exit 1
    fi
}

ORG_PATH="${HOME}/JavaPlebes"
PROJ_DIR="/TextAdventure"
GIT_URL="git@github.com:javaplebes/TextAdventure.git"

if [ ! -d "${ORG_PATH}" ]; then
  echo "Organisation path does not exist. Creating..."
  mkdir "${ORG_PATH}"
fi

cd "${ORG_PATH}" || echo "Unable to change directory to: ${ORG_PATH}. Exiting..."; exit 1

if [ ! -d "${PROJ_DIR}" ]; then
  echo "Project directory does not exist. Cloning latest from GitHub..."
  git clone "${GIT_URL} ${PROJ_DIR}"
fi

cd "${PROJ_DIR}" || echo "Unable to change directory to: ${PROJ_DIR}. Exiting..."; exit 1

echo "Pulling the latest master branch..."
git pull origin master

mvn compile
mvn test
mvn package

# Running of JAR on server currently disabled as not sure how to present the 'frontend' of the game.
ARTIFACT_ID=$(get_xpath_value "/pom.xml" "project/artifactId")
VERSION=$(get_xpath_value "/pom.xml" "project/version")
#java -jar "/target/${ARTIFACT_ID}-${VERSION}.jar"

echo "Deployed: ${ARTIFACT_ID}-${VERSION}"