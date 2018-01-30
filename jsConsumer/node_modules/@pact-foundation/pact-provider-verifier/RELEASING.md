# Releasing

* Set the GEM_VERSION and RELEASE_VERSION for the version of the pact-provider-verifier standalone package you wish to use in `scripts/build.sh`
* Update the version number in each `package.json` file to the next appropriate semantic version.

    export VERSION=$(cat package.json | jq -r .version)
    git add *package.json scripts/build.sh && git status
    git commit -m "Releasing version ${VERSION}" && git push
    git tag -a v${VERSION} -m "Releasing version ${VERSION}" && git push origin v${VERSION}
