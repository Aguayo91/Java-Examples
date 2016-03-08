package com.studytrails.patterns.abstract_factory;

public class BasicMaintenance implements Maintenance
{
    public BasicMaintenance(String name)
    {
        this.name = name;
    }
    String name;
    @Override
    public String getName()
    {
        return name;
    }
}
