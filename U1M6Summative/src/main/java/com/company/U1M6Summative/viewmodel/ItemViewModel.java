package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Item;

import java.util.Objects;

public class ItemViewModel {
        private int itemId;
        private String name;
        private String description;
        private double dailyRate;


        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getDailyRate() {
            return dailyRate;
        }

        public void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemViewModel)) return false;
        ItemViewModel that = (ItemViewModel) o;
        return itemId == that.itemId &&
                Double.compare(that.dailyRate, dailyRate) == 0 &&
                Objects.equals(name, that.name) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, description, dailyRate);
    }
}
