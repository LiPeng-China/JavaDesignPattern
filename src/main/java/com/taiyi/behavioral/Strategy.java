package com.taiyi.behavioral;

import java.math.BigDecimal;

/**
 * 策略接口
 */
interface PaymentStrategy {
    void payment(BigDecimal amount);
}

/**
 * 微信支付策略
 */

class WechatPaymentStrategy implements PaymentStrategy {

    @Override
    public void payment(BigDecimal amount) {
        System.out.println("使用微信支付" + amount);
    }
}

/**
 * 支付宝支付
 */
class AlipayPaymentStrategy implements PaymentStrategy {

    @Override
    public void payment(BigDecimal amount) {
        System.out.println("使用支付宝支付" + amount);
    }
}

/**
 * 云闪付支付
 */
class UnionPayPaymentStrategy implements PaymentStrategy {
    @Override
    public void payment(BigDecimal amount) {
        System.out.println("使用云闪付支付" + amount);
    }
}

/**
 * 支付服务
 */
class PaymentService {
    public void payment(PaymentStrategy paymentStrategy, BigDecimal amount) {
        paymentStrategy.payment(amount);
    }
}

/**
 * 测试
 */
public class Strategy {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        paymentService.payment(new AlipayPaymentStrategy(), new BigDecimal("100"));
        paymentService.payment(new WechatPaymentStrategy(), new BigDecimal("100"));
        paymentService.payment(new UnionPayPaymentStrategy(), new BigDecimal("100"));

    }
}