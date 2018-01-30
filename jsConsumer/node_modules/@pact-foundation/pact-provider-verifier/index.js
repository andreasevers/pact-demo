var arch = "";
if (process.platform === 'linux') {
	arch = '-' + process.arch;
}
var packageName = '@pact-foundation/pact-provider-verifier-' + process.platform + arch;

module.exports = require(packageName);