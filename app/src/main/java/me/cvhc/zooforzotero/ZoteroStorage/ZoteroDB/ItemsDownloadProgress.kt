package me.cvhc.zooforzotero.ZoteroStorage.ZoteroDB

data class ItemsDownloadProgress(
    val libraryVersion: Int,
    val nDownloaded: Int,
    val total: Int //tbh useless
)