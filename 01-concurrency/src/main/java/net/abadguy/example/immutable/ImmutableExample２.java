package net.abadguy.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;
import net.abadguy.annoations.ThreadSafe;

@Slf4j
@ThreadSafe
public class ImmutableExample２ {

   private final static ImmutableList list=ImmutableList.of(1,2,3);

   private final static ImmutableSet set=ImmutableSet.copyOf(list);

   private final static ImmutableMap<Integer,Integer> map= ImmutableMap.of(1,2,3,4);

    public static void main(String[] args) {
        System.out.println(map.get(1));
    }
}
