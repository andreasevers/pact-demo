<img src="https://github.com/pact-foundation/pact-logo/blob/master/media/logo-black.png" width="200">

# Pact Provider Verifier for NPM

[![Build Status](https://travis-ci.org/pact-foundation/pact-provider-verifier-npm.svg?branch=master)](https://travis-ci.org/pact-foundation/pact-provider-verifier-npm)

Installation wrapper for standalone platform-specific executables packaged from the Ruby [pact-provider-verifier](https://github.com/pact-foundation/pact-provider-verifier) gem.

On install, this package selects and installs the correct standalone executable for your environment.

This node module downloads the appropriate platform-specific and installs it alongside `pact-provider-verifier` inside the node_modules directory.

## Usage

```
npm install @pact-foundation/pact-provider-verifier
node_modules/.bin/pact-provider-verifier <options>
```

# Known issues

The packaged binary always prints out the following message on startup. Have not yet traced the source.

```
No entry for terminal type "xterm-256color";
using dumb terminal settings.
```

On npm install, the following warnings will be displayed. They do not appear to affect the behaviour of the provider verifier.

```
npm WARN excluding symbolic link lib/ruby/lib/libcrypto.dylib -> libcrypto.1.0.0.dylib
npm WARN excluding symbolic link lib/ruby/lib/libedit.dylib -> libedit.0.dylib
npm WARN excluding symbolic link lib/ruby/lib/libffi.dylib -> libffi.6.dylib
npm WARN excluding symbolic link lib/ruby/lib/libgmp.dylib -> libgmp.10.dylib
npm WARN excluding symbolic link lib/ruby/lib/liblzma.dylib -> liblzma.5.dylib
npm WARN excluding symbolic link lib/ruby/lib/libncurses.dylib -> libncurses.5.dylib
npm WARN excluding symbolic link lib/ruby/lib/libreadline.dylib -> libedit.0.dylib
npm WARN excluding symbolic link lib/ruby/lib/libssl.dylib -> libssl.1.0.0.dylib
npm WARN excluding symbolic link lib/ruby/lib/libtermcap.dylib -> libncurses.5.dylib
npm WARN excluding symbolic link lib/ruby/lib/libyaml.dylib -> libyaml-0.2.dylib
```
