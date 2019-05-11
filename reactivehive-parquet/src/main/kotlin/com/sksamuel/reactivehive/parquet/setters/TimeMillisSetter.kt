package com.sksamuel.reactivehive.parquet.setters

import com.sksamuel.reactivehive.TimeMillis
import org.apache.parquet.io.api.RecordConsumer

object TimeMillisSetter : Setter {
  override fun set(consumer: RecordConsumer, value: Any) {
    val millis = when (value) {
      is TimeMillis -> value.millis
      is Int -> value
      else -> throw UnsupportedOperationException()
    }
    consumer.addInteger(millis)
  }
}
