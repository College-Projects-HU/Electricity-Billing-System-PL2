package com.example.electricity_billing_system.Models;


import java.util.List;
/*  json ex
{
    "tariffs": [
    {
        "type": "fixed",
            "rate": 0.05
    },
    {
        "type": "tiered",
            "tiers": [
        {"limit": 100, "rate": 0.05},
        {"limit": 300, "rate": 0.07},
        {"limit": 500, "rate": 0.10}
      ]
    }
}
]
}
          */
public class Tariff {
    private String type;  // Can be "fixed", "tiered", "time_of_use"
    private double ratePerUnit;  // For "fixed" tariff
    private List<Tier> tiers;  // For "tiered" tariff
    private double fixedCharge;  // For "time_of_use" tariff

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRatePerUnit() {
        return ratePerUnit;
    }

    public void setRatePerUnit(double ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }

    public List<Tier> getTiers() {
        return tiers;
    }

    public void setTiers(List<Tier> tiers) {
        this.tiers = tiers;
    }


    public double getFixedCharge() {
        return fixedCharge;
    }

    public void setFixedCharge(double fixedCharge) {
        this.fixedCharge = fixedCharge;
    }

    // Inner class to represent a tier in the tiered tariff
    public static class Tier {
        private int limit;
        private double rate;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }
    }
}

