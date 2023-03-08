package entity;

public class KPacSet {
    private int id;
    private int KPacId;
    private int SetId;

    public KPacSet() {}

    public KPacSet(int id, int KPacId, int setId) {
        this.id = id;
        this.KPacId = KPacId;
        SetId = setId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKPacId() {return KPacId;}

    public void setKPacId(int KPacId) {
        this.KPacId = KPacId;
    }

    public int getSetId() {
        return SetId;
    }

    public void setSetId(int setId) {
        SetId = setId;
    }
}
