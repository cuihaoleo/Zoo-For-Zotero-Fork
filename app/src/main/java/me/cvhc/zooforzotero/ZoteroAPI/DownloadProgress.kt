package me.cvhc.zooforzotero.ZoteroAPI

data class DownloadProgress(
    val progress: Long,
    val total: Long,
    val mtime: Long = -1,
    val metadataHash: String = ""
)