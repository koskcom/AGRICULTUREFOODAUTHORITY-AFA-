package co.ke.bsl.data.view;

public class CurrencyView {
    public CurrencyView(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String Name;
}
