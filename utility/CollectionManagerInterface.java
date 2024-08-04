package utility;

import data.LabWork;

import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

public interface CollectionManagerInterface {

    public Vector<LabWork> getLabWorkVector();

    public LocalDate getLastInitTime();
    public LabWork addFromInput();
    public void updateByIdCollection(int id);
    public void loadCollection();
    public int getId();
    public void clear();
    public boolean checkExist(int id);



}