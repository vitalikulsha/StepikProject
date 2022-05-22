package server;

import resources.TestResource;

public interface ResourceServer {
    String getName();

    int getAge();

    void setTestResource(TestResource testResource);
}
