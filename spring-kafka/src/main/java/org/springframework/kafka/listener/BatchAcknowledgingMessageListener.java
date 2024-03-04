/*
 * Copyright 2015-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.kafka.listener;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.kafka.support.Acknowledgement;

/**
 * Listener for handling a batch of incoming Kafka messages, propagating an acknowledgement
 * handle that recipients can invoke when the message has been processed. The list is
 * created from the consumer records object returned by a poll.
 *
 * @param <K> the key type.
 * @param <V> the value type.
 *
 * @author Marius Bogoevici
 * @author Gary Russell
 *
 * @since 1.1
 */
@FunctionalInterface
public interface BatchAcknowledgingMessageListener<K, V> extends BatchMessageListener<K, V> {

	/**
	 * Invoked with data from kafka. Containers should never call this since it they
	 * will detect that we are an acknowledging listener.
	 * @param data the data to be processed.
	 */
	@Override
	default void onMessage(List<ConsumerRecord<K, V>> data) {
		throw new UnsupportedOperationException("Container should never call this");
	}

	@Override
	void onMessage(List<ConsumerRecord<K, V>> data, Acknowledgement acknowledgement);

}
