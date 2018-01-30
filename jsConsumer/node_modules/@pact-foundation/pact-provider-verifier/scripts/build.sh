#!/bin/bash -e

set -e

export GEM_VERSION=1.1.4
export RELEASE_VERSION=2
export PACKAGE_VERSION=${GEM_VERSION}-${RELEASE_VERSION}

scripts/build_standalone_packages.sh

export STANDALONE_PACKAGE_NAME="pact-provider-verifier-${PACKAGE_VERSION}-win32"
export NPM_PACKAGE_NAME='pact-provider-verifier-win32'
export SUFFIX='win32'
export EXTENSION='zip'
scripts/package_for_npm.sh

export STANDALONE_PACKAGE_NAME="pact-provider-verifier-${PACKAGE_VERSION}-osx"
export NPM_PACKAGE_NAME='pact-provider-verifier-darwin'
export SUFFIX='osx'
export EXTENSION='tar.gz'
scripts/package_for_npm.sh

export STANDALONE_PACKAGE_NAME="pact-provider-verifier-${PACKAGE_VERSION}-linux-x86"
export NPM_PACKAGE_NAME='pact-provider-verifier-linux-ia32'
export SUFFIX='linux-x86'
export EXTENSION='tar.gz'
scripts/package_for_npm.sh

export STANDALONE_PACKAGE_NAME="pact-provider-verifier-${PACKAGE_VERSION}-linux-x86_64"
export NPM_PACKAGE_NAME='pact-provider-verifier-linux-x64'
export SUFFIX='linux-x86_64'
export EXTENSION='tar.gz'
scripts/package_for_npm.sh
