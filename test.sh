#!/bin/bash
# 1 build and install locally archetype generator
# 2 script to auto generate project with default values, artifactId is webapp
# 3 compilation, packaging , and testing of auto generated project
# 4 compilation, packaging , and testing with docker maven runner of auto generated project

clear

# check maven dependencies
(
    type mvn &>/dev/null || ( echo "maven is not available"; exit 1 )
)>&2

#version archetype
VERSION_SMSA=0.0.5
#version Bill of Material generated project parent POM
VERSION_BOM=3.0.4

mvn -q versions:set -DnewVersion="$VERSION_SMSA"

#### 1 build and install locally
mvn clean install

echo "+++++++++++++++++++++++++++++++++++++++++++++++"
echo "run maven archetype:generate locally in $PWD"
echo "+++++++++++++++++++++++++++++++++++++++++++++++"
echo ""

#### 2 test with default values artefact generation
cd target
mvn -B archetype:generate \
        -DarchetypeGroupId=fr.ans \
        -DarchetypeArtifactId=archetype-java \
        -DarchetypeVersion=$VERSION_SMSA
echo "-----------------------------------------------"
echo ""

cd miniservice
#mvn versions:update-parent "-DparentVersion=$VERSION_BOM"
#mvn -q versions:set-property -Dproperty=spring-mvc-start-archetype.version -DnewVersion="$VERSION"

echo "+++++++++++++++++++++++++++++++++++++++++++++++"
echo "run maven locally in $PWD"
echo "+++++++++++++++++++++++++++++++++++++++++++++++"
echo ""

#### 3 test compilation, packaging , and testing
mvn -q package test -Ptest
echo "-----------------------------------------------"
echo ""
