/**********************************************************************
Copyright (c) 2012 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
**********************************************************************/
package com.google.appengine.datanucleus.test.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@Entity
public class UnownedJPAManyToManySideB {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key key;

  @Unowned
  @ManyToMany(cascade=CascadeType.ALL)
  private Set<UnownedJPAManyToManySideA> as = new HashSet<UnownedJPAManyToManySideA>();

  public Key getKey() {
    return key;
  }

  public Set<UnownedJPAManyToManySideA> getAs() {
    return as;
  }
}
