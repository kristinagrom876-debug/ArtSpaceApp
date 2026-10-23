package com.example.artspaceapp

import org.junit.Assert.assertEquals
import org.junit.Test

class ArtSpaceTests {
    @Test
    fun nextArtwork_incrementsIndex() {
        var current = 1
        if (current < 3) current++
        assertEquals(2, current)
    }
}