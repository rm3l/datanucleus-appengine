/**********************************************************************
Copyright (c) 2009 Google Inc.

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
package com.google.appengine.datanucleus.test.jdo;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class HasRecursiveParentJDO {

  public HasRecursiveParentJDO() {
  }

  @PersistenceCapable
  public static class HasRecursiveParent {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    private String id;

    @Persistent
    private String name;

    @Persistent
    private HasRecursiveParent parent;

    @Persistent(mappedBy = "parent")
    private Set<HasRecursiveParent> children = new HashSet<HasRecursiveParent>();

    public String getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public HasRecursiveParent getParent() {
      return parent;
    }

    public void setParent(HasRecursiveParent parent) {
      this.parent = parent;
    }

    public Set<HasRecursiveParent> getChildren() {
      return children;
    }
  }
  
}
