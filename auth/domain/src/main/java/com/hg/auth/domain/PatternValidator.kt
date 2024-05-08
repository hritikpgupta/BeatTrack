package com.hg.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}