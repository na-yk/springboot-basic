package org.devcourse.voucher.domain;

public class PercentDiscountVoucher extends Voucher {
    private final VoucherType type = VoucherType.PERCENT;
    private final long discountPercent;

    public PercentDiscountVoucher(long discountPercent) {
        super();
        if(discountPercent >= 0){
            throw new IllegalArgumentException("discountPercent는 0보다 커야 합니다.");
        }
        else {
            this.discountPercent = discountPercent;
        }
    }

    public VoucherType getType() {
        return type;
    }

    @Override
    public long discount(long beforeDiscount) throws IllegalArgumentException {
        if (beforeDiscount < 0) {
            throw new IllegalArgumentException("beforeDiscount는 음수일 수 없습니다.");
        }
        double discountRate = discountPercent / 100.0;
        double discountAmount = beforeDiscount * discountRate;

        return beforeDiscount - (long) discountAmount;
    }

    public long getDiscountAmount(long beforeDiscount) throws IllegalArgumentException{
        if (beforeDiscount < 0) {
            throw new IllegalArgumentException("beforeDiscount는 음수일 수 없습니다.");
        }
        double discountRate = discountPercent / 100.0;
        double discountAmount = beforeDiscount * discountRate;

        return (long) discountAmount;
    }

    public long getDiscountPercent() {
        return discountPercent;
    }
}
