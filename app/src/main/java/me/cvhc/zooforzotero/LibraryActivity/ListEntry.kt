package me.cvhc.zooforzotero.LibraryActivity

import me.cvhc.zooforzotero.ZoteroStorage.Database.Collection
import me.cvhc.zooforzotero.ZoteroStorage.Database.Item

// holds either a collection or an Item
class ListEntry {
    private var collection: Collection? = null
    private var item: Item? = null

    constructor(item: Item) {
        this.item = item
    }

    constructor(collection: Collection) {
        this.collection = collection
    }

    fun isItem(): Boolean {
        return (item != null)
    }

    fun isCollection(): Boolean {
        return (collection != null)
    }

    fun getItem(): Item {
        return item!!
    }

    fun getCollection(): Collection {
        return collection!!
    }
}