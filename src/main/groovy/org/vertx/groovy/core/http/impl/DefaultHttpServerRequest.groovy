package org.vertx.groovy.core.http.impl

import org.vertx.groovy.core.buffer.Buffer
import org.vertx.groovy.core.http.HttpServerRequest
import org.vertx.groovy.core.http.HttpServerResponse
import org.vertx.java.core.Handler
import org.vertx.java.core.http.MultiMap

import javax.net.ssl.SSLPeerUnverifiedException
import javax.security.cert.X509Certificate

/*
 * Copyright 2013 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
class DefaultHttpServerRequest implements HttpServerRequest {

  private org.vertx.java.core.http.HttpServerRequest jRequest

  private HttpServerResponse response

  DefaultHttpServerRequest(org.vertx.java.core.http.HttpServerRequest jRequest) {
    this.jRequest = jRequest
    this.response = new DefaultHttpServerResponse(jRequest.response())
  }

  @Override
  String getMethod() {
    jRequest.method()
  }

  @Override
  String getUri() {
    jRequest.uri()
  }

  @Override
  String getPath() {
    jRequest.path()
  }

  @Override
  String getQuery() {
    jRequest.query()
  }

  @Override
  HttpServerResponse getResponse() {
    response
  }

  @Override
  MultiMap getHeaders() {
    jRequest.headers()
  }

  @Override
  MultiMap getParams() {
    jRequest.params()
  }

  @Override
  InetSocketAddress getRemoteAddress() {
    jRequest.remoteAddress()
  }

  @Override
  X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
    jRequest.peerCertificateChain()
  }

  @Override
  URI getAbsoluteURI() {
    jRequest.absoluteURI()
  }

  @Override
  HttpServerRequest bodyHandler(Closure handler) {
    jRequest.bodyHandler(({handler(new Buffer(it))} as Handler))
    this
  }

  @Override
  HttpServerRequest dataHandler(Closure handler) {
    jRequest.dataHandler(({handler(new Buffer(it))} as Handler))
    this
  }

  @Override
  HttpServerRequest pause() {
    jRequest.pause()
    this
  }

  @Override
  HttpServerRequest resume() {
    jRequest.resume()
    this
  }

  @Override
  HttpServerRequest endHandler(Closure endHandler) {
    jRequest.endHandler(endHandler as Handler)
    this
  }

  @Override
  HttpServerRequest exceptionHandler(Closure handler) {
    jRequest.exceptionHandler(handler as Handler)
    this
  }

}
