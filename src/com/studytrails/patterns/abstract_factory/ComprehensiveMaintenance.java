package com.studytrails.patterns.abstract_factory;

public class ComprehensiveMaintenance implements Maintenance
{
    String name;
    public ComprehensiveMaintenance(String name)
    {
        this.name = name;
    }
    @Override
    public String getName()
    {
        return name;
    }
}
