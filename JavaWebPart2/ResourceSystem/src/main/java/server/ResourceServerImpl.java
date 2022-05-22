package server;

import resources.TestResource;

public class ResourceServerImpl implements ResourceServer {
    private TestResource testResource;

    public ResourceServerImpl() {
    }

    public ResourceServerImpl(TestResource testResource) {
        this.testResource = testResource;
    }

    @Override
    public String getName(){
        return testResource.getName();
    }

    @Override
    public int getAge(){
        return testResource.getAge();
    }

    @Override
    public void setTestResource(TestResource testResource) {
        this.testResource = testResource;
    }
}
