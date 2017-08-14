package OJ;

import java.util.List;

/**
 * Created by arachis on 2017/8/8.
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.

 However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

 You are given the each item's price, a set of special offers, and the number we need to buy for each item.
 The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

 Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer,
 other numbers represents how many specific items you could get if you buy this offer.

 You could use any of special offers as many times as you want.

 Example 1:
 Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
 Output: 14
 Explanation:
 There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
 In special offer 1, you can pay $5 for 3A and 0B
 In special offer 2, you can pay $10 for 1A and 2B.
 You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 Example 2:
 Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 Output: 11
 Explanation:
 The price of A is $2, and $3 for B, $4 for C.
 You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
 You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
 You cannot add more items, though only $9 for 2A ,2B and 1C.
 *
 */
public class Shopping_Offers {
      /**
       * The basic idea is to pick each offer, and subtract the needs. And then compute the price without the offer.
       Pick whichever is minimum.
       */
      public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int result = Integer.MAX_VALUE;
            //apply each offer to the needs, and recurse
            for(int i = 0; i < special.size(); i++) {
                  List<Integer> offer = special.get(i);
                  boolean invalidOffer = false;
                  int offerCount = Integer.MAX_VALUE; // number of times offer can be applied
                  for(int j = 0; j < needs.size(); j++) { // pre-compute number of times offer can be called
                      int remain = needs.get(j) - offer.get(j);
                      if(!invalidOffer && remain < 0) invalidOffer = true; // if offer has more items than needs
                      if(offer.get(j) > 0)
                         offerCount = Math.min(offerCount, needs.get(j)/offer.get(j));
                  }
             for(int j = 0; j < needs.size(); j++) { // subtract offer items from needs
                  int remain = needs.get(j) - offer.get(j) * offerCount;
                  needs.set(j, remain);
             }
             if(!invalidOffer) { //if valid offer, add offer price and recurse remaining needs
                 result = Math.min(result, shoppingOffers(price, special, needs) + (offerCount * offer.get(needs.size())));
             }

             for(int j = 0; j < needs.size(); j++) { // reset the needs
                  int remain = needs.get(j) + offer.get(j) * offerCount;
                  needs.set(j, remain);
             }
            }

            // choose b/w offer and non offer
            int nonOfferPrice = 0;
            for(int i = 0; i < needs.size(); i++) {
                  nonOfferPrice += price.get(i) * needs.get(i);
            }
            return Math.min(result, nonOfferPrice);
      }

}
