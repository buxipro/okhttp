package okhttp3

object SecurityBridge {

    @Volatile
    @JvmField
    var securityPassed: Boolean = false

    @JvmStatic
    fun isSecurityPassed(): Boolean {
        return securityPassed
    }

    @JvmStatic
    fun setSecurityPassed(passed: Boolean) {
        securityPassed = passed
    }
}