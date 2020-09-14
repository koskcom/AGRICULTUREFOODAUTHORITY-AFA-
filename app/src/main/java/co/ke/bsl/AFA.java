package co.ke.bsl;

import android.app.Application;
import android.graphics.Typeface;

import androidx.lifecycle.MutableLiveData;

import com.facebook.stetho.Stetho;

import org.idempiere.webservice.client.base.LoginRequest;

import java.util.ArrayList;
import java.util.List;

import co.ke.bsl.pojo.ADUser;
import co.ke.bsl.pojo.Agent;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CaneCensusDataCollection;
import co.ke.bsl.pojo.CaneCensusFarmer;
import co.ke.bsl.pojo.City;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.Customer;
import co.ke.bsl.pojo.Group;
import co.ke.bsl.pojo.GroupLoan;
import co.ke.bsl.pojo.HorticultureCropExportLicenceFarmInspectionDetails;
import co.ke.bsl.pojo.Product;
import co.ke.bsl.pojo.RetailLooseSugarPricesRangeImported;
import co.ke.bsl.pojo.Shop;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.pojo.Survey;
import co.ke.bsl.pojo.User;
import co.ke.bsl.pojo.UserData;
import co.ke.bsl.pojo.WholeSaleBrandLocal;
import co.ke.bsl.pojo.WholeSaleImportedStockedSugar;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.pojo.WholeSaleStockedBrandLocal;
import co.ke.bsl.settings.Settings;
import co.ke.bsl.util.TypeFactory;

public class AFA extends Application {
    private static AFA mInstance;
    public Settings settings;
    private TypeFactory mFontFactory;

    public static synchronized AFA getApp() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        settings = new Settings(getApplicationContext());

        Stetho.initializeWithDefaults(this);

        mInstance = this;
    }

    public Typeface getTypeFace(int type) {
        if (mFontFactory == null)
            mFontFactory = new TypeFactory(this);

        switch (type) {
            case Constants.REGULAR:
                return mFontFactory.getRegular();

            case Constants.BOLD:
                return mFontFactory.getBold();

            default:
                return mFontFactory.getRegular();
        }
    }

    public interface Constants {
        int REGULAR = 1,
                BOLD = 2;
    }
    
    private User user;

    private User savedUser;

    private ADUser adUser;

    protected LoginRequest loginRequest;
    
    private Agent agent;
    
    private UserData userData;
    
    private Shop shop;
    
    private Group group;
    
    private String agentId;
    
    private Customer customer;
    
    private String customerId;
    
    private String surveyType;
    
    private String AFA_SD_Canecensusscore_ID;
    
    private String AFA_SD_Canefarmerdetails_ID;
    
    
    private ArrayList<Customer> customerList;
    
    private ArrayList<String> savingTypeList;
    
    private ArrayList<GroupLoan>  groupLoanList;
    
    private ArrayList<SubCounty> subCountyList;
    
    private City city;
    
    private WholeSaleBrandLocal wholeSaleBrandLocal;
    
    private WholeSaleImportedSugar wholeSaleImportedSugar;
    
    private WholeSaleStockedBrandLocal wholeSaleStockedBrandLocal;
    
    private WholeSaleImportedStockedSugar wholeSaleImportedStockedSugar;
    
    private List<WholeSaleImportedSugar> wholeSaleImportedSugarList;
    
    
    private List<WholeSaleImportedStockedSugar> wholeSaleImportedStockedSugarList;
    
    private List<WholeSaleBrandLocal>  wholeSaleBrandLocalList;
    
    private List<WholeSaleStockedBrandLocal> wholeSaleStockedBrandLocalList;
    
    private List<City>  cityList=new ArrayList<>();
    
    private List<Country>  countryList  =new ArrayList<>();
    
    private List<County>  CountyList=  new ArrayList<>();
    
    protected List<CBPartner> companyList =new ArrayList<>();
    
    protected List<Product> productsList =new ArrayList<>();
    
    private County county;
    
    private SubCounty subCounty;
    
    private CBPartner company;
    
    private Survey survey;
    
    private GroupLoan groupLoan;
    
    private Country importSugarCountryOfOrigin;
    
    private CaneCensusDataCollection caneCensusDataCollection;

    private MutableLiveData<CoffeeNursercertInsp> coffeeNurseryInspection;

    private MutableLiveData<HorticultureCropExportLicenceFarmInspectionDetails> horticultureCropExportLicenceFarmInspectionDetails;

    public MutableLiveData<CoffeeNursercertInsp> getCoffeeNurseryInspection() {
        if (coffeeNurseryInspection == null) {
            coffeeNurseryInspection = new MutableLiveData<CoffeeNursercertInsp>();
        }
        return coffeeNurseryInspection;
    }

    public MutableLiveData<HorticultureCropExportLicenceFarmInspectionDetails> getHorticultureCropExportLicenceFarmInspectionDetails() {
        if (horticultureCropExportLicenceFarmInspectionDetails == null) {
            horticultureCropExportLicenceFarmInspectionDetails = new MutableLiveData<HorticultureCropExportLicenceFarmInspectionDetails>();
        }
        return horticultureCropExportLicenceFarmInspectionDetails;
    }

    private CaneCensusFarmer caneCensusFarmer;
    
    public CaneCensusFarmer getCaneCensusFarmer() {
        return caneCensusFarmer;
    }
    
    public void setCaneCensusFarmer(CaneCensusFarmer caneCensusFarmer) {
        this.caneCensusFarmer = caneCensusFarmer;
    }
    
    public CaneCensusDataCollection getCaneCensusDataCollection() {
        return caneCensusDataCollection;
    }
    
    public void setCaneCensusDataCollection(CaneCensusDataCollection caneCensusDataCollection) {
        this.caneCensusDataCollection = caneCensusDataCollection;
    }
    
    public List<Product> getProductsList() {
        return productsList;
    }
    
    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
    
    public String getAFA_SD_Canefarmerdetails_ID() {
        return AFA_SD_Canefarmerdetails_ID;
    }
    
    public void setAFA_SD_Canefarmerdetails_ID(String AFA_SD_Canefarmerdetails_ID) {
        this.AFA_SD_Canefarmerdetails_ID = AFA_SD_Canefarmerdetails_ID;
    }
    
    private RetailLooseSugarPricesRangeImported retailLooseSugarPricesRangeImported;
    
    private Country importSugarStockedCountryOfOrigin;
    
    public void setSubCountyList(ArrayList<SubCounty> subCountyList) {
        this.subCountyList = subCountyList;
    }
    
    public SubCounty getSubCounty() {
        return subCounty;
    }
    
    public void setSubCounty(SubCounty subCounty) {
        this.subCounty = subCounty;
    }
    
    public ArrayList<SubCounty> getSubCountyList() {
        return subCountyList;
    }
    
    public String getAFA_SD_Canecensusscore_ID() {
        return AFA_SD_Canecensusscore_ID;
    }
    
    public void setAFA_SD_Canecensusscore_ID(String AFA_SD_Canecensusscore_ID) {
        this.AFA_SD_Canecensusscore_ID = AFA_SD_Canecensusscore_ID;
    }
    
    public List<CBPartner> getCompanyList() {
        return companyList;
    }
    
    public void setCompanyList(List<CBPartner> companyList) {
        this.companyList = companyList;
    }
    
    public CBPartner getCompany() {
        return company;
    }
    
    public void setCompany(CBPartner company) {
        this.company = company;
    }
    
    public County getCounty() {
        return county;
    }
    
    public void setCounty(County county) {
        this.county = county;
    }
    
    public List<County> getCountyList() {
        return CountyList;
    }
    
    public void setCountyList(List<County> countyList) {
        CountyList = countyList;
    }
    
    public String getSurveyType() {
        return surveyType;
    }
    
    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }
    
    public RetailLooseSugarPricesRangeImported getRetailLooseSugarPricesRangeImported() {
        return retailLooseSugarPricesRangeImported;
    }
    
    public void setRetailLooseSugarPricesRangeImported(RetailLooseSugarPricesRangeImported retailLooseSugarPricesRangeImported) {
        this.retailLooseSugarPricesRangeImported = retailLooseSugarPricesRangeImported;
    }
    
    public LoginRequest getLoginRequest() {
        return loginRequest;
    }
    
    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }
    
    public WholeSaleImportedStockedSugar getWholeSaleImportedStockedSugar() {
        return wholeSaleImportedStockedSugar;
    }
    
    public void setWholeSaleImportedStockedSugar(WholeSaleImportedStockedSugar wholeSaleImportedStockedSugar) {
        this.wholeSaleImportedStockedSugar = wholeSaleImportedStockedSugar;
    }
    
    public WholeSaleStockedBrandLocal getWholeSaleStockedBrandLocal() {
        return wholeSaleStockedBrandLocal;
    }
    
    public void setWholeSaleStockedBrandLocal(WholeSaleStockedBrandLocal wholeSaleStockedBrandLocal) {
        this.wholeSaleStockedBrandLocal = wholeSaleStockedBrandLocal;
    }
    
    public WholeSaleImportedSugar getWholeSaleImportedSugar() {
        return wholeSaleImportedSugar;
    }
    
    public void setWholeSaleImportedSugar(WholeSaleImportedSugar wholeSaleImportedSugar) {
        this.wholeSaleImportedSugar = wholeSaleImportedSugar;
    }
    
    public Shop getShop() {
        return shop;
    }
    
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    
    public List<WholeSaleImportedStockedSugar> getWholeSaleImportedStockedSugarList() {
        return wholeSaleImportedStockedSugarList ;
    }
    
    public City getCity() {
        return city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
    
    public WholeSaleBrandLocal getWholeSaleBrandLocal() {
        return wholeSaleBrandLocal;
    }
    
    public void setWholeSaleBrandLocal(WholeSaleBrandLocal wholeSaleBrandLocal) {
        this.wholeSaleBrandLocal = wholeSaleBrandLocal;
    }
    
    public List<WholeSaleImportedSugar> getWholeSaleImportedSugarList() {
        return wholeSaleImportedSugarList;
    }
    
    public void setWholeSaleImportedSugarList(List<WholeSaleImportedSugar> wholeSaleImportedSugarList) {
        this.wholeSaleImportedSugarList = wholeSaleImportedSugarList;
    }
    
    public void setWholeSaleImportedStockedSugarList(List<WholeSaleImportedStockedSugar> wholeSaleImportedStockedSugarList) {
        this.wholeSaleImportedStockedSugarList = wholeSaleImportedStockedSugarList;
    }
    
    public List<WholeSaleBrandLocal> getWholeSaleBrandLocalList() {
        return wholeSaleBrandLocalList;
    }
    
    public void setWholeSaleBrandLocalList(List<WholeSaleBrandLocal> wholeSaleBrandLocalList) {
        this.wholeSaleBrandLocalList = wholeSaleBrandLocalList;
    }
    
    public List<WholeSaleStockedBrandLocal> getWholeSaleStockedBrandLocalList() {
        return wholeSaleStockedBrandLocalList;
    }
    
    public void setWholeSaleStockedBrandLocalList(List<WholeSaleStockedBrandLocal> wholeSaleStockedBrandLocalList) {
        this.wholeSaleStockedBrandLocalList = wholeSaleStockedBrandLocalList;
    }
    
    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
    
    public List<Country> getCountryList() {
        return countryList;
    }
    
    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
    
    public Survey getSurvey() {
        return survey;
    }
    
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
    
    public Country getImportSugarCountryOfOrigin() {
        return importSugarCountryOfOrigin;
    }
    
    public void setImportSugarCountryOfOrigin(Country importSugarCountryOfOrigin) {
        this.importSugarCountryOfOrigin = importSugarCountryOfOrigin;
    }
    
    public Country getImportSugarStockedCountryOfOrigin() {
        return importSugarStockedCountryOfOrigin;
    }
    
    public void setImportSugarStockedCountryOfOrigin(Country importSugarStockedCountryOfOrigin) {
        this.importSugarStockedCountryOfOrigin = importSugarStockedCountryOfOrigin;
    }
    
    public List<City> getCityList() {
        return cityList;
    }
    
    
    
    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }
    
    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    /**
     * @return the userData
     */
    public UserData getUserData() {
        return userData;
    }
    
    /**
     * @param userData the userData to set
     */
    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    /**
     * @return the adUser
     */
    public ADUser getAdUser() {
        return adUser;
    }

    /**
     * @param adUser the adUser to set
     */
    public void setAdUser(ADUser adUser) {
        this.adUser = adUser;
    }

    /**
     * @return the savedUser
     */
    public User getSavedUser() {
        return savedUser;
    }

    /**
     * @param savedUser the adUser to set
     */
    public void setSavedUser(User savedUser) {
        this.savedUser = savedUser;
    }

    /**
     * @return the group
     */



    public Group getGroup() {
        return group;
    }
    
    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
        this.group = group;
    }
    
    /**
     * @return the agent
     */
    public Agent getAgent() {
        return agent;
    }
    
    /**
     * @param agent the agent to set
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    
    /**
     * @return the agentId
     */
    public String getAgentId() {
        return agentId;
    }
    
    /**
     * @param agentId the agentId to set
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
    
    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }
    
    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    
    /**
     * @return the customerList
     */
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
    /**
     * @param customerList the customerList to set
     */
    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
    /**
     * @return the savingTypeList
     */
    public ArrayList<String> getSavingTypeList() {
        return savingTypeList;
    }
    
    /**
     * @param savingTypeList the savingTypeList to set
     */
    public void setSavingTypeList(ArrayList<String> savingTypeList) {
        this.savingTypeList = savingTypeList;
    }
    
    /**
     * @return the groupLoanList
     */
    public ArrayList<GroupLoan> getGroupLoanList() {
        return groupLoanList;
    }
    
    /**
     * @param groupLoanList the groupLoanList to set
     */
    public void setGroupLoanList(ArrayList<GroupLoan> groupLoanList) {
        this.groupLoanList = groupLoanList;
    }
    
    /**
     * @return the groupLoan
     */
    public GroupLoan getGroupLoan() {
        return groupLoan;
    }
    
    /**
     * @param groupLoan the groupLoan to set
     */
    public void setGroupLoan(GroupLoan groupLoan) {
        this.groupLoan = groupLoan;
    }
}