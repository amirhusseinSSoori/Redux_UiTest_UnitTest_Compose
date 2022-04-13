package com.amirhusseinsoori.domain.exception

public class CustomResult<T> constructor(
    val value: Any?
) {
    fun exceptionOrNull(): Throwable? =
        when (value) {
            is Failure -> value.exception
            else -> null
        }

    override fun toString(): String =
        when (value) {
            is Failure -> value.toString()
            else -> "Success($value)"
        }

    companion object {
        fun <T> success(value: T): CustomResult<T> =
            CustomResult(value)


        fun <T> failure(exception: Throwable): CustomResult<T> =
            CustomResult(Failure(exception))
    }

    internal class Failure(
        val exception: Throwable
    ) {
        override fun equals(other: Any?): Boolean = other is Failure && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Failure($exception)"
    }


}









