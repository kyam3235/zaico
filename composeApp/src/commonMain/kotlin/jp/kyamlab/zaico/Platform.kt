package jp.kyamlab.zaico

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform