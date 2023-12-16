package me.cvhc.zooforzotero.ZoteroAPI

import me.cvhc.zooforzotero.ZoteroAPI.Model.CollectionPOJO

data class ZoteroAPICollectionsResponse(
    val isCached: Boolean,
    val collections: List<CollectionPOJO>,
    val totalResults: Int
)